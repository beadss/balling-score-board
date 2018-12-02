package bowling.frame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by naver on 2018. 11. 26..
 */
public class FrameImplTest {

	@Test
	public void addBall() {
		Frame frame = makeFrame();

		assertTrue(frame.addBall(1));
		assertFalse(frame.addBall(1));
	}

	@Test(expected = IllegalStateException.class)
	public void addBall_overBallCountSize() {
		Frame frame = makeFrame();

		assertTrue(frame.addBall(1));
		assertFalse(frame.addBall(1));

		frame.addBall(1);
	}

	@Test(expected = IllegalStateException.class)
	public void addBall_overPinCount() {
		Frame frame = makeFrame();
		assertTrue(frame.addBall(9));
		frame.addBall(2);
	}

	private Frame makeFrame() {
		return new FrameImpl();
	}
}
