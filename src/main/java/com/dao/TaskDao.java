package com.dao;

import com.mapper.TaskMapper;
import com.model.todo.Task;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TaskDao {
    private final TaskMapper mapper;

    private TaskDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(TaskMapper.class);
    }

    public void makeTask(Task task) {
        mapper.makeTask(task);
    }

    public ArrayList<Task> getUserTasks(String userToken) {
        return mapper.getUserTasks(userToken);
    }

    public ArrayList<Task> getUserTasksByComplete(String userToken, boolean complete) {
        return mapper.getUserTasksByComplete(userToken, complete);
    }

    public void updateTask(Task task) {
        mapper.updateTask(task);
    }

    public void deleteTask(int no) {
        mapper.deleteTask(no);
    }

    public void deleteUserCompletedTasks(String userToken) {
        mapper.deleteUserCompletedTasks(userToken);
    }

    public Task getTaskByNo(int no) {
        return mapper.getTaskByNo(no);
    }
}
