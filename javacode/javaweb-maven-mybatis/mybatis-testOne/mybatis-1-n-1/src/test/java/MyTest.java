import com.yyds.mapper.PoJoMapper;
import com.yyds.mapper.StudentMapper;
import com.yyds.mapper.TeacherMapper;
import com.yyds.pojo.PoJo;
import com.yyds.pojo.Student;
import com.yyds.pojo.Teacher;
import com.yyds.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        PoJoMapper smapper=sqlSession.getMapper(PoJoMapper.class);
//        List<PoJo> studentList=smapper.getStudent();
//        for (PoJo poJo : studentList) {
//            System.out.println(poJo);
//        }
        //学生查询
//        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList=studentMapper.getStudent();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
        //教师查询
        TeacherMapper tmapper=sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList=tmapper.getTeacher(1);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }
}

