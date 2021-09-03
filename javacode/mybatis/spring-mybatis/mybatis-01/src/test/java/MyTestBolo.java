import com.zyds.mapper.BolgMapper;
import com.zyds.pojo.Bolg;
import com.zyds.utils.GetUUID;
import com.zyds.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTestBolo {
//    @Test
//    public void addBolg(){
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        Map<String,Object> bolgMap=new HashMap<>();
//        bolgMap.put("id",GetUUID.getUUID());
//
//        System.out.println(GetUUID.getUUID());
//        bolgMap.put("bolg","java必读");
//        Date date=new Date();
//        bolgMap.put("creationDate",date);
//        bolgMap.put("views",8909);
//        BolgMapper mapper=sqlSession.getMapper(BolgMapper.class);
//        mapper.addBolg(bolgMap);
//
//        Map bolgMap1=new HashMap();
//        bolgMap1.put("id",GetUUID.getUUID());
//        bolgMap1.put("bolg","c++必读");
//        bolgMap1.put("creationDate",date);
//        bolgMap1.put("views",12999);
//        mapper.addBolg(bolgMap1);
//
//        Map bolgMap2=new HashMap();
//        bolgMap2.put("id",GetUUID.getUUID());
//        bolgMap2.put("bolg","golang必读");
//        bolgMap2.put("creationDate",date);
//        bolgMap2.put("views",2048);
//        mapper.addBolg(bolgMap2);
//
//        Map bolgMap3=new HashMap();
//        bolgMap3.put("id",GetUUID.getUUID());
//        bolgMap3.put("bolg","python必读");
//        bolgMap3.put("creationDate",date);
//        bolgMap3.put("views",9099);
//        mapper.addBolg(bolgMap3);
//        sqlSession.commit();
//        sqlSession.close();
//    }
    @Test
    public void testGetBolgIf(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        BolgMapper bolgMapper=sqlSession.getMapper(BolgMapper.class);
        Map map=new HashMap();
        map.put("bolg","c++必读");
        List<Bolg> bolgList=bolgMapper.getBolgIf(map);
        for (Bolg bolg : bolgList) {
            System.out.println(bolg);
        }


        sqlSession.close();
    }
}
