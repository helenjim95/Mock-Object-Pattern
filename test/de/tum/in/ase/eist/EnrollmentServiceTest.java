package de.tum.in.ase.eist;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
class EnrollmentServiceTest {

	// 1. setup EnrollmentServiceTest with all necessary attributes
	@TestSubject
	private EnrollmentService enrollmentService = new EnrollmentService();
	@Mock
	private Course courseMock;

	@Test
	void testEnrollStudentSuccessful() {
		// 2: implement the test
		Student student = new Student();
		int expectedSize = student.getCourses().size() + 1;
		expect(courseMock.enroll(student)).andReturn(true);
		replay(courseMock);
		enrollmentService.enroll(student, courseMock);
		assertEquals(expectedSize, student.getCourses().size());
	}

	@Test
	void testEnrollStudentFailure() {

		// 3: Implement the test (optional)
		Student student = new Student();
		int expectedSize = student.getCourses().size();
		expect(courseMock.enroll(student)).andReturn(false);
		replay(courseMock);
		enrollmentService.enroll(student, courseMock);
		assertEquals(expectedSize, student.getCourses().size());
	}

}
