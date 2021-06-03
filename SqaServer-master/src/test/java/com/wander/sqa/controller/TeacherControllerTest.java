package com.wander.sqa.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wander.sqa.dto.user.SubjectTeacherStatDTO;
import com.wander.sqa.dto.user.TeacherStatDTO;
import com.wander.sqa.entity.user.Teacher;
import com.wander.sqa.service.user.TeacherService;
import com.wander.sqa.service.user.TeacherServiceImpl;
import com.wander.sqa.dao.TeacherDAO;
@SpringBootTest
class TeacherControllerTest{

	@Autowired
	private TeacherService teacherService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
//	Kiểm tra độ lớn của dữ liệu
	public void testGetAll() {
		List<TeacherStatDTO> list = teacherService.getAll();
		assertEquals(4, list.size());
		
	}
	@Test
//	Kiểm tra size dữ liệu có rỗng không
	public void testGetAll1() {
		List<TeacherStatDTO> list = teacherService.getAll();
		assertNotNull(list.size());		
	}
	
	@Test
//	Kiểm tra số môn đăng ký
	public void testGetSpecific1() {
		List<TeacherStatDTO> list = teacherService.getAll();	
		List<TeacherStatDTO> l = list.stream().filter(item -> item.getId() == 2).collect(Collectors.toList());
//		assertEquals(1, l.size());
		assertEquals(2, l.get(0).getForgot());
	}
	
	@Test
//	Kiểm tra số môn chưa đăng ký
	public void testGetSpecific2() {
		List<TeacherStatDTO> list = teacherService.getAll();	
		List<TeacherStatDTO> l = list.stream().filter(item -> item.getId() == 2).collect(Collectors.toList());
//		assertEquals(1, l.size());
		assertEquals(2, l.get(0).getRemember());
	}
	
	@Test
//	Kiểm tra xem có đúng tên " Nguyễn Thị B" trong danh sách đăng ký với id=2 không
	public void testGetSpecific() {
		List<TeacherStatDTO> list = teacherService.getAll();	
		List<TeacherStatDTO> l = list.stream().filter(item -> item.getId() == 2).collect(Collectors.toList());
//		assertEquals(1, l.size());
		assertEquals("Nguyễn Thị B", l.get(0).getFullname());
	}
	
	@Test
//	Xem danh sach dang ky voi idfindRemember ngoài CSDL
	public void testGetTẹacherByIdRememeber1() {		
		List<SubjectTeacherStatDTO> list = teacherService.findRemember(99);	
		assertEquals(1,list.size());
		
	}
	@Test
//	Xem danh sach dang ky voi idfindRemember có trong CSDL
	public void testGetTẹacherByIdRememeber() {		
		List<SubjectTeacherStatDTO> list = teacherService.findRemember(2);	
		assertEquals(1,list.size());
		
	}
}
