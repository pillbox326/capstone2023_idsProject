/*
package dachaja.idsProject.domain.makePDF.FlowDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

public class FlowController {

    private final FlowService flowService;

    @Autowired
    FlowController(FlowService flowService){
        this.flowService = flowService;
    }

*/
/*    @GetMapping("/flowDB")
    public List<FlowData> getAllDB(){
        return flowService.getAllDB();
    }*//*


    @GetMapping("/flowData")
    public List<Map<String, Object>> getFlowDB(){
        return flowService.getFlowDB();
    }
}
*/
