package com.wander.sqa.service.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.wander.sqa.dao.TeacherDAO;
import com.wander.sqa.dto.user.SubjectTeacherStatDTO;
import com.wander.sqa.dto.user.TeacherStatDTO;
import com.wander.sqa.entity.registration.AssignedSubject;
import com.wander.sqa.entity.registration.Registration;
import com.wander.sqa.entity.user.Account;
import com.wander.sqa.entity.user.Address;
import com.wander.sqa.entity.user.Department;
import com.wander.sqa.entity.user.Fullname;
import com.wander.sqa.entity.user.Member;
import com.wander.sqa.entity.user.Role;
import com.wander.sqa.entity.user.Teacher;
import com.wander.sqa.exception.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeacherServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class TeacherServiceImplTest {
    @MockBean
    private TeacherDAO teacherDAO;

    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @Test
    public void testFindByUsername() throws UsernameNotFoundException {
        Department department = new Department();
        department.setId(5);
        department.setName("A");
        department.setTeacher(new HashSet<Teacher>());

        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setMember(new Member());
        fullname.setMiddlename("V??n");
        fullname.setFirstname("Nguy???n");
        fullname.setLastname("A");

        Account account = new Account();
        account.setPassword("User_12345");
        account.setUsername("Teacher3");
        account.setId(5);
        account.setMember(new Member());
        account.setRole(new Role());

        Address address = new Address();
        address.setDistrict("District");
        address.setId(5);
        address.setCity("HN");
        address.setMember(new Member());
        address.setDescription(" ");
        address.setStreet("HD");

        Member member = new Member();
        member.setEmail("teacher3@gmail.com");
        member.setId(5);
        member.setPhone("4105551212");
        member.setFullname(fullname);
        member.setAccount(account);
        member.setAddress(address);

        Role role = new Role();
        role.setId(5);
        role.setName("A");
        role.setAccount(new HashSet<Account>());

        Teacher teacher = new Teacher();
        teacher.setEmail("teacher3@gmail.com");
        teacher.setDepartment(department);
        teacher.setId(5);
        teacher.setRegistration(new HashSet<Registration>());
        teacher.setPhone("4105551212");
        teacher.setFullname(fullname);
        teacher.setAccount(account);
        teacher.setAssignedSubject(new HashSet<AssignedSubject>());
        teacher.setTchCode("GV5");
        teacher.setAddress(address);
        Optional<Teacher> ofResult = Optional.<Teacher>of(teacher);
        when(this.teacherDAO.findByUsername(anyString())).thenReturn(ofResult);
        assertEquals(5, this.teacherServiceImpl.findByUsername("").getId());
        assertTrue(this.teacherServiceImpl.getAll().isEmpty());
    }

    @Test
    public void testFindRemember() {
        Department department = new Department();
        department.setId(5);
        department.setName("A");
        department.setTeacher(new HashSet<Teacher>());

        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setMember(new Member());
        fullname.setMiddlename("V??n");
        fullname.setFirstname("Nguy???n");
        fullname.setLastname("A");

        Account account = new Account();
        account.setPassword("User_12345");
        account.setUsername("Teacher3");
        account.setId(5);
        account.setMember(new Member());
        account.setRole(new Role());

        Address address = new Address();
        address.setDistrict("District");
        address.setId(5);
        address.setCity("HN");
        address.setMember(new Member());
        address.setDescription(" ");
        address.setStreet("HD");

        Member member = new Member();
        member.setEmail("teacher3@gmail.com");
        member.setId(5);
        member.setPhone("4105551212");
        member.setFullname(fullname);
        member.setAccount(account);
        member.setAddress(address);

        Role role = new Role();
        role.setId(5);
        role.setName("A");
        role.setAccount(new HashSet<Account>());

        Teacher teacher = new Teacher();
        teacher.setEmail("teacher3@gmail.com");
        teacher.setDepartment(department);
        teacher.setId(5);
        teacher.setRegistration(new HashSet<Registration>());
        teacher.setPhone("4105551212");
        teacher.setFullname(fullname);
        teacher.setAccount(account);
        teacher.setAssignedSubject(new HashSet<AssignedSubject>());
        teacher.setTchCode("GV5");
        teacher.setAddress(address);

        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        when(this.teacherDAO.findRemember(anyLong())).thenReturn(teacherList);
        List<SubjectTeacherStatDTO> actualFindRememberResult = this.teacherServiceImpl.findRemember(5);
        assertNotNull(actualFindRememberResult.size());
        SubjectTeacherStatDTO getResult = actualFindRememberResult.get(0);
        assertEquals("GV5", getResult.getCode());
        assertEquals(5, getResult.getId());
        assertEquals("Nguy???n V??n A", getResult.getFullname());
        assertTrue(this.teacherServiceImpl.getAll().isEmpty());
    }

    @Test
    public void testFindForgot2() {
        Department department = new Department();
        department.setId(5);
        department.setName("A");
        department.setTeacher(new HashSet<Teacher>());

        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setMember(new Member());
        fullname.setMiddlename("V??n");
        fullname.setFirstname("Nguy???n");
        fullname.setLastname("A");

        Account account = new Account();
        account.setPassword("User_12345");
        account.setUsername("Teacher3");
        account.setId(5);
        account.setMember(new Member());
        account.setRole(new Role());

        Address address = new Address();
        address.setDistrict("District");
        address.setId(5);
        address.setCity("HN");
        address.setMember(new Member());
        address.setDescription(" ");
        address.setStreet("HD");

        Member member = new Member();
        member.setEmail("teacher3@gmail.com");
        member.setId(5);
        member.setPhone("4105551212");
        member.setFullname(fullname);
        member.setAccount(account);
        member.setAddress(address);

        Role role = new Role();
        role.setId(5);
        role.setName("A");
        role.setAccount(new HashSet<Account>());

        Teacher teacher = new Teacher();
        teacher.setEmail("teacher3@gmail.com");
        teacher.setDepartment(department);
        teacher.setId(5);
        teacher.setRegistration(new HashSet<Registration>());
        teacher.setPhone("4105551212");
        teacher.setFullname(fullname);
        teacher.setAccount(account);
        teacher.setAssignedSubject(new HashSet<AssignedSubject>());
        teacher.setTchCode("GV5");
        teacher.setAddress(address);

        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        when(this.teacherDAO.findForgot(anyLong())).thenReturn(teacherList);
        List<SubjectTeacherStatDTO> actualFindForgotResult = this.teacherServiceImpl.findForgot(5);
        assertEquals(1, actualFindForgotResult.size());
        SubjectTeacherStatDTO getResult = actualFindForgotResult.get(0);
        assertEquals("GV5", getResult.getCode());
        assertEquals(5, getResult.getId());
        assertEquals("Nguy???n V??n A", getResult.getFullname());
        assertTrue(this.teacherServiceImpl.getAll().isEmpty());
    }


    @Test
    public void testGetAll() {
        Department department = new Department();
        department.setId(5);
        department.setName("A");
        department.setTeacher(new HashSet<Teacher>());

        Fullname fullname = new Fullname();
        fullname.setId(5);
        fullname.setMember(new Member());
        fullname.setMiddlename("V??n");
        fullname.setFirstname("Nguy???n");
        fullname.setLastname("A");

        Account account = new Account();
        account.setPassword("User_12345");
        account.setUsername("Teacher3");
        account.setId(5);
        account.setMember(new Member());
        account.setRole(new Role());

        Address address = new Address();
        address.setDistrict("District");
        address.setId(5);
        address.setCity("HN");
        address.setMember(new Member());
        address.setDescription(" ");
        address.setStreet("HD");

        Member member = new Member();
        member.setEmail("teacher3@gmail.com");
        member.setId(5);
        member.setPhone("4105551212");
        member.setFullname(fullname);
        member.setAccount(account);
        member.setAddress(address);

        Role role = new Role();
        role.setId(5);
        role.setName("A");
        role.setAccount(new HashSet<Account>());

        Teacher teacher = new Teacher();
        teacher.setEmail("teacher3@gmail.com");
        teacher.setDepartment(department);
        teacher.setId(5);
        teacher.setRegistration(new HashSet<Registration>());
        teacher.setPhone("4105551212");
        teacher.setFullname(fullname);
        teacher.setAccount(account);
        teacher.setAssignedSubject(new HashSet<AssignedSubject>());
        teacher.setTchCode("GV5");
        teacher.setAddress(address);

        ArrayList<Object[]> objectArrayList = new ArrayList<Object[]>();
        objectArrayList.add(new Object[]{teacher});
        when(this.teacherDAO.findTeacherWithNumberOfFullRegGroup()).thenReturn(new ArrayList<Object[]>());
        when(this.teacherDAO.findTeacherWithNumberOfGroup()).thenReturn(objectArrayList);
        assertTrue(this.teacherServiceImpl.getAll().isEmpty());

    }

    @Test
//	Ki???m tra size d??? li???u c?? r???ng kh??ng
    public void testGetAll2() {
        List<TeacherStatDTO> list = teacherServiceImpl.getAll();
        assertNotNull(list.size());
    }



    @Test
    public void testGetFullname() {
        Fullname fullname = new Fullname();
        assertEquals("null  null", this.teacherServiceImpl.getFullname(fullname));
        assertEquals("", fullname.getMiddlename());
    }

    @Test
    public void testGetFullname2() {
        Fullname fullname = mock(Fullname.class);
        when(fullname.getLastname()).thenReturn("A");
        when(fullname.getFirstname()).thenReturn("Nguy???n");
        when(fullname.getMiddlename()).thenReturn("V??n");
        assertEquals("Nguy???n V??n A", this.teacherServiceImpl.getFullname(fullname));
    }

    @Test
    public void testGetFullname3() {
        Fullname fullname = mock(Fullname.class);
        doNothing().when(fullname).setMiddlename(anyString());
        when(fullname.getLastname()).thenReturn("A");
        when(fullname.getFirstname()).thenReturn("Nguy???n");
        when(fullname.getMiddlename()).thenReturn(null);
        assertEquals("Nguy???n null A", this.teacherServiceImpl.getFullname(fullname));
        assertTrue(this.teacherServiceImpl.getAll().isEmpty());
    }
}

