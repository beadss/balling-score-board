package frame;

import frame.ball.Ball;
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

		assertTrue(frame.addBall(new Ball(1)));
		assertFalse(frame.addBall(new Ball(1)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addBall_overBallCountSize() {
		Frame frame = makeFrame();

		assertTrue(frame.addBall(new Ball(1)));
		assertFalse(frame.addBall(new Ball(1)));

		frame.addBall(new Ball(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addBall_overPinCount() {
		Frame frame = makeFrame();
		assertTrue(frame.addBall(new Ball(9)));
		frame.addBall(new Ball(2));
	}

	private Frame makeFrame() {
		return new FrameImpl();
	}
}
