package dachaja.idsProject.domain.makePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*public interface IdsInfoRepository extends CrudRepository<IdsInfo, Long>{
}*/

@Repository
public class IdsInfoRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

/*    public List<String> getCurrentDB(){
        List<String> DBList = new ArrayList<>();
        DBList.addAll(jdbcTemplate.queryForList("select Label from capstone2023.idsInfo;",String.class));
        return DBList;
    }*/

/*
    @GetMapping("/info")
    public List<String> getCurrentDB(){
        List<String> tempList = new ArrayList<>();
        tempList.addAll(jdbcTemplate.queryForObject("select * from capstone2023.idsInfo where Label != \"Benign\" order by id desc limit 1;",String.class));
        return tempList;
    }

*/

/*
    @GetMapping("/info")
    public IdsInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
        IdsInfo idsInfo = new IdsInfo();
        idsInfo.setId(rs.getInt("id"));
        idsInfo.setSrcIP(rs.getString("SrcIP"));

        return idsInfo;
    }*/
}
