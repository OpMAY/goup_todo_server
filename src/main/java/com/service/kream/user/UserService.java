package com.service.kream.user;

import com.aws.file.FileUploadUtility;
import com.dao.AccountInfoDao;
import com.dao.DeletedUserDao;
import com.dao.StyleDao;
import com.dao.UserDao;
import com.model.User;
import com.model.common.MFile;
import com.model.kream.user.LOGIN_TYPE;
import com.model.kream.user.delete.DeletedUser;
import com.model.kream.user.style.StyleUser;
import com.response.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final AccountInfoDao accountInfoDao;
    private final StyleDao styleDao;
    private final DeletedUserDao deletedUserDao;
    private final FileUploadUtility fileUploadUtility;


    public User getProfileInfo(int user_no) {

        return userDao.getProfileInfo(user_no);
    }

    public User getUserbyToken(String access_token){
        return userDao.getUserbyToken(access_token);
    }

    @Transactional
    public User registUser(User user, StyleUser styleUser) {
        /**
         *  1. user Table data insert
         *  2. style_user Table data insert
         * **/
        String randomId = UUID.randomUUID().toString();
        userDao.registUser(user);

        User result = userDao.getProfileInfo(user.getNo());

        styleUser.setProfile_name(randomId);
        styleUser.setName(user.getName());
//        styleDao.registStyleUser(styleUser);

        return result;
    }

    @Transactional
    public void updateEmail(String email, int user_no) {
        userDao.updateEmail(email, user_no);
    }

    @Transactional
    public void updateUserName(String name, int user_no) {
        userDao.updateUserName(name, user_no);
    }

    @Transactional
    public void updatePhoneNumber(String phone_number, int user_no) {
        /*
         * 1. user table에 내 USER_NO가 아닌 사람 중에 같은 phone_number를 가진 사람이 있는지 확인
         * 2. update false
         * 4. ph 리스트에 없으면 update true
         * */
        userDao.updatePhoneNumber(phone_number, user_no);
    }

    @Transactional
    public void updateSize(int size, int user_no) {
        userDao.updateSize(size, user_no);
    }

    @Transactional
    public void updateEmailAlarm(int email_alarm, int user_no) {
        userDao.updateEmailAlarm(email_alarm, user_no);
    }

    @Transactional
    public void updateReceiptInfo(User user) {
        userDao.updateReceiptInfo(user);
    }

    @Transactional
    public void updateProfileImage(MultipartFile multipartFile, int user_no) {
        /**
         * 1. 이미지 등록 ? 삭제 ?
         * 2. 이미지 등록이면 프론트에서 업로드 한 파일 우리가 S3에 업로드
         * 3. 업로드 완료하면 해당 ROUTE 기준으로 URL 생성해서 MFILE 따로 만들어서 넣어야함
         * **/
        if (multipartFile == null) {
            userDao.updateProfileImage(null, user_no);
        } else {
            MFile mFile = fileUploadUtility.uploadFile(multipartFile, "/image/user/profile/" + user_no + "/");
            userDao.updateProfileImage(mFile, user_no);
        }


    }

    @Transactional
    public void deleteUser(int no) {
        /**
         *
         *  1. user_flag 값 확인 1이면
         *  1-1.user 테이블 user_flag 1->0으로  변경 (1:사용중인 유저 2: 미사용 유저)
         *  2. userDeleted 테이블 data insert
         * **/

        User user = userDao.getProfileInfo(no);

        if (user.getUser_flag() == 1) {
            int user_flag = 0;
            userDao.deletedUser(no, user_flag);

            DeletedUser deletedUser = new DeletedUser();
            deletedUser.setUser_no(no);
            deletedUser.setAccess_token(user.getAccess_token());
            deletedUser.setLogin_type(user.getLogin_type());

            deletedUserDao.createDelUser(deletedUser);
        }
    }

    @Transactional
    public Message updateProfile(User user,Message message) {
        int no = user.getNo();
        Integer email_alarm = user.getEmail_alarm();
        Integer size = user.getSize();
        MultipartFile file = (MultipartFile) user.getProfile_img();
        LOGIN_TYPE login_type = user.getLogin_type();

        if (user.getName() != null) {
            this.updateUserName(user.getName(), no);
        } else if (user.getEmail() != null) {
            this.updateEmail(user.getEmail(), no);
        } else if (user.getPhone_number() != null) {
            this.updatePhoneNumber(user.getPhone_number(), no);
        } else if (size != null) {
            this.updateSize(size, no);
        } else if (email_alarm != null) {
            this.updateEmailAlarm(email_alarm, no);
        } else if (file != null) {
            this.updateProfileImage(file, no);
        }
        return message.put("USER", userDao.getProfileInfo(user.getNo()));
    }

    public boolean checkUserExists(LOGIN_TYPE login_type, String access_token) {
        return userDao.checkUserExists(login_type, access_token);
    }

    public User getUserByLoginInfo(LOGIN_TYPE login_type, String access_token) {
        return userDao.getUserByLoginInfo(login_type, access_token);
    }

    public void userSuspended(int no,int user_flag) {
         userDao.userSuspended(no,user_flag);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
