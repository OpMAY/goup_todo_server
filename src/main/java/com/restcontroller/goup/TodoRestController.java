package com.restcontroller.goup;

import com.dao.TaskDao;
import com.model.todo.TASK_UPDATE_TYPE;
import com.model.todo.Task;
import com.response.DefaultRes;
import com.response.Message;
import com.service.todo.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoRestController {
    private final TodoService todoService;
    private final TaskDao taskDao;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity getTasks(@RequestParam("userToken") String userToken, @RequestParam(value = "complete", required = false) String complete) {
        Message message = new Message();
        Boolean cBool = complete == null ? null : complete.equals("y");
        message.put("tasks", todoService.getTask(userToken, cBool));
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "'/task/make", method = RequestMethod.POST)
    public ResponseEntity makeTask(@RequestBody Task task) {
        Message message = new Message();
        message.put("status", todoService.makeTask(task));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/task/delete", method = RequestMethod.POST)
    public ResponseEntity deleteTask(@RequestParam("userToken") String userToken, @RequestParam("no") int no) {
        Message message = new Message();
        if (todoService.checkTaskBelongToUser(no, userToken)) {
            todoService.deleteTask(no);
            message.put("status", true);
        } else {
            message.put("status", false);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/task/update", method = RequestMethod.POST)
    public ResponseEntity updateTask(@RequestBody Task task) {
        Message message = new Message();
        todoService.updateTask(task, TASK_UPDATE_TYPE.COMPLETE);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/task/delete/complete", method = RequestMethod.POST)
    public ResponseEntity deleteUserCompletedTask(@RequestParam("userToken") String userToken) {
        Message message = new Message();
        todoService.deleteUserCompletedTasks(userToken);
        message.put("status",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
