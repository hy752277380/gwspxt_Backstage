package com.kcsj.gwglxt.serviceImpl.processManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;
import com.kcsj.gwglxt.mapper.ProcessMapper;
import com.kcsj.gwglxt.mapper.ProcessNodeMapper;
import com.kcsj.gwglxt.service.processManage.ProcessService;
import com.kcsj.gwglxt.util.TeamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessMapper processMapper;
    @Autowired
    private ProcessNodeMapper processNodeMapper;

    //根据流程id查询流程节点详细信息
    @Override
    public List<ProcessInfo> getProNodeByPro(String processId) {
        return processNodeMapper.getProNodeByPro(processId);
    }

    @Override
    public int addProcessNode(ProcessNode processNode) {
        int maxStep = processNodeMapper.getMaxStep(processNode.getProcessNodeProcess());
        processNode.setProcessNodeId(TeamUtil.getUuid());
        processNode.setProcessNodeStep(maxStep+1);
        processNode.setProcessNodeIsdelete(0);
        return processNodeMapper.insert(processNode);
    }

    @Override
    public int deleteProcessNode(String processNodeId) {
        //查询该节点对应的流程
        ProcessNode newProcesNode = processNodeMapper.selectByPrimaryKey(processNodeId);
        //执行删除操作
        ProcessNode changeItems = new ProcessNode();
        changeItems.setProcessNodeId(processNodeId);
        changeItems.setProcessNodeIsdelete(1);
        int result = processNodeMapper.updateByPrimaryKeySelective(changeItems);
        //将被删除节点的后面几个节点位置前移
        //从查询的节点信息中获取流程，将查询本流程中步骤大于被删除节点的其他节点
        List<ProcessNode> processNodes = processNodeMapper.getOthers(newProcesNode.getProcessNodeProcess(),newProcesNode.getProcessNodeStep());
        //判断是否还有其他节点
        if(processNodes==null&&"".equals(processNodes)){
            System.out.println("已经是最后一个节点");
        }
        else {
            //遍历processNodes
            for(ProcessNode processNode:processNodes){
                ProcessNode changeStep = new ProcessNode();
                changeStep.setProcessNodeId(processNode.getProcessNodeId());
                changeStep.setProcessNodeStep(processNode.getProcessNodeStep()-1);
                processNodeMapper.updateByPrimaryKeySelective(changeStep);
            }
        }
        return result;
    }
    //删除流程
    @Override
    public int deleteProcess(String[] ids) {
        int result = 0;
        if (ids==null&&"".equals(ids)){
            return 0;
        }else{
            //遍历id删除
            for (String processId:ids){
                Process process = new Process();
                process.setProcessId(processId);
                process.setProcessIsdelete(1);
                int deleteResult = processMapper.updateByPrimaryKeySelective(process);
                result = result + deleteResult;
            }
            return result;
        }
    }

}
