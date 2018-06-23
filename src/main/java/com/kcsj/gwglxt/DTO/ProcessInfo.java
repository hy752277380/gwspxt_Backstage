package com.kcsj.gwglxt.DTO;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;

public class ProcessInfo {
    private ProcessNode process_node;
    private Process process;
    private Department department;
    private Position position;

    public ProcessNode getProcess_node() {
        return process_node;
    }

    public void setProcess_node(ProcessNode process_node) {
        this.process_node = process_node;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "process_node=" + process_node +
                ", process=" + process +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
