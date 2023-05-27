package dachaja.idsProject.domain.makePDF.Controller;


import dachaja.idsProject.domain.makePDF.IdsInfo;
import dachaja.idsProject.domain.makePDF.IdsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path="/ids")
public class InfoController {

    @Autowired
    IdsInfoRepository idsInfoRepository;


/*
    @GetMapping(path="/info")
    public List<String> getAllDB(){
        return idsInfoRepository.getCurrentDB();
    }
*/

    @GetMapping("/info")
    public IdsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        IdsInfo idsInfo = new IdsInfo();
        idsInfo.setId(rs.getInt("id"));
        idsInfo.setSrcIP(rs.getString("SrcIP"));

        return idsInfo;
    }

}
