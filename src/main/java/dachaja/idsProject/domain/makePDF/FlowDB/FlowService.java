/*
package dachaja.idsProject.domain.makePDF.FlowDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class FlowService {

    //private final FlowRepository flowRepository;

*/
/*    @Autowired
    public FlowService(FlowRepository flowRepository){
        //this.flowRepository = flowRepository;
    }*//*


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FlowService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String,Object>> getFlowDB(){//(String condition){
        String query = "select * from idsinfo";
        return jdbcTemplate.queryForList(query);
    }

*/
/*    public List<FlowData> getAllDB(){
        return flowRepository.findAll();
    }*//*

}
*/
