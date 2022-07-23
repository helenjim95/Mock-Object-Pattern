package de.tum.in.ase.eist;

//TODO: import EasyMock
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

//TODO: import EasyMock
import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//TODO: Easymock annotation
@ExtendWith(EasyMockExtension.class)
class EnrollmentServiceTest {

	// TODO: 1. setup EnrollmentServiceTest with all necessary attributes
	@TestSubject
	private EnrollmentService enrollmentService = new EnrollmentService();
	@Mock
	private Course courseMock;

	@Test
	void testEnrollStudentSuccessful() {
		// TODO: 2: implement the test
//      TODO: dummy object to be passed as parameter
		Student student = new Student();
		int expectedSize = student.getCourses().size() + 1;
//		TODO: specify the behavior -> hardcode output of a method call
		expect(courseMock.enroll(student)).andReturn(true);
//		TODO: make the Mock ready to play
		replay(courseMock);
//		TODO: test the method of the system enrollmentService with dummy/mock
		enrollmentService.enroll(student, courseMock);
//		TODO: assert the expected and observed output
		assertEquals(expectedSize, student.getCourses().size());
//		TODO: check if the Mock has been called in the test (optional)
		verify(courseMock);
	}

	@Test
	void testEnrollStudentFailure() {
		// TODO: 3: Implement the test
		Student student = new Student();
		int expectedSize = student.getCourses().size();
		expect(courseMock.enroll(student)).andReturn(false);
		replay(courseMock);
		enrollmentService.enroll(student, courseMock);
		assertEquals(expectedSize, student.getCourses().size());
		verify(courseMock);
	}

}
