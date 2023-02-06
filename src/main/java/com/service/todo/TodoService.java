package com.service.todo;

import com.dao.TaskDao;
import com.model.todo.TASK_UPDATE_TYPE;
import com.model.todo.Task;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {
    private final TaskDao taskDao;
    private final EncryptionService encryptionService;

    @Transactional
    public boolean makeTask(Task task) {
        taskDao.makeTask(task);
        return task.getNo() != 0;
    }

    public ArrayList<Task> getTask(String userToken, Boolean complete) {
        if(complete != null) {
            return taskDao.getUserTasksByComplete(userToken, complete);
        } else {
            return taskDao.getUserTasks(userToken);
        }
    }

    @Transactional
    public boolean updateTask(Task task, TASK_UPDATE_TYPE type) {
        Task originalTask = taskDao.getTaskByNo(task.getNo());
        if(originalTask != null) {
            switch (type) {
                case TITLE:
                    originalTask.setTitle(task.getTitle());
                case COMPLETE:
                    originalTask.setComplete(task.isComplete());
                case CONTENT:
                default:
            }
            taskDao.updateTask(originalTask);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void deleteTask(int  no) {
        taskDao.deleteTask(no);
    }

    @Transactional
    public void deleteUserCompletedTasks(String userToken) {
        taskDao.deleteUserCompletedTasks(userToken);
    }
}
