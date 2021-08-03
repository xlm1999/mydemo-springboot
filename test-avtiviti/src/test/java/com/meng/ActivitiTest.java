package com.meng;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActivitiTest extends ActBoot2ApplicationTest {
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    TaskService taskService;
    @Autowired
    ProcessEngine processEngine;

    /**
     * 部署流程
     *
     */
    @Test
    public void deployFlow() {
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/demo2.bpmn").deploy();
        System.out.println("deploymentId========" + deployment);
    }
    /*启动实例*/
    @Test
    public void test5(){
        //去数据库表名为act_re_procdef 取出主键 启动流程实例
        String definitionId = "test:4:20004" ;
        ProcessInstance processInstance = processEngine
                .getRuntimeService().startProcessInstanceById(definitionId);
        System.out.println(processInstance.getId());
        //去act_run_task表中，根据holiday:1:60004 查看任务运行状态
    }
    /**
     * 启动流程
     *
     *
     * Created by Bryce Yao<sysyaoyulong@gmail.com> on Jun 8, 2017.
     */
    @Test
    public void start() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("hello");
        System.out.println("processInstance=========" + processInstance);
    }

    @Test
    public void check(){
        List<Task> tasks=taskService.createTaskQuery().processDefinitionId("myProcess:3:5004").list();
        for (Task task : tasks) {
            System.out.println("task=========" + task);
        }
    }


    @Test
    public void test(){

//        ProcessInstance pi = runtimeService.startProcessInstanceByKey("hello");
//        System.out.println("process id:  " + pi.getId());
//        System.out.println("process name:  " + pi.getName());
//        System.out.println("desc :  " + pi.getDescription());
//
//        System.out.println(taskService.createTaskQuery());

        // 获取任务
        /*TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskAssignee("lili").list();
        System.out.println("任务个数" + list.size());
        if (list != null && list.size() > 0) {
            for (Task t : list) {
                System.out.print(t.getId() + ",");
                System.out.print(t.getName() + ",");
                System.out.print(t.getAssignee() + ",");
                System.out.println(t.getProcessInstanceId());
            }
        }*/
    }
}
