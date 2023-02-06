package com.mapper;

import com.model.todo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface TaskMapper {
    void makeTask(Task task);

    ArrayList<Task> getUserTasks(String userToken);

    ArrayList<Task> getUserTasksByComplete(@Param("userToken") String userToken, @Param("complete") boolean complete);

    void updateTask(Task task);

    void deleteTask(int no);

    void deleteUserCompletedTasks(String userToken);

    Task getTaskByNo(int no);
}
