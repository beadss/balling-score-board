package frame.ball;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by naver on 2018. 11. 26..
 */
public class BallTest {

	@Test
	public void makeBall() {
		for(int i = 0; i <= 10; i++) {
			new Ball(i);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void makeBall_overSize() {
		new Ball(11);
	}

	@Test
	public void strike() {
		Ball one = new Ball(10);
		Ball dummy = new Ball(1);

		dummy.setBallStatus(one);

		assertEquals(one.getBallStatus(), BallStatus.STRIKE);
	}

	@Test
	public void spare() {
		int maxPin = 10;
		for(int i = 0; i < 10; i++) {
			Ball one = new Ball(i);
			Ball two = new Ball(maxPin-i);

			two.setBallStatus(one);

			assertEquals(one.getBallStatus(), BallStatus.NONE);
			assertEquals(two.getBallStatus(), BallStatus.SPARE);
		}
	}

	@Test
	public void openFrame() {
		int underMaxPin = 9;
		for(int i = 0; i < 10; i++) {
			Ball one = new Ball(i);
			Ball two = new Ball(underMaxPin-i);

			two.setBallStatus(one);

			assertEquals(one.getBallStatus(), BallStatus.NONE);
			assertEquals(two.getBallStatus(), BallStatus.OPEN_FRAME);
		}
	}
}
