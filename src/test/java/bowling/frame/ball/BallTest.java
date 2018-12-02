package bowling.frame.ball;

import org.junit.Test;

/**
 * Created by naver on 2018. 11. 26..
 */
public class BallTest {

	@Test
	public void makeBall() {
		for(int i = 0; i <= 10; i++) {
			new Ball(i, BallStatus.NONE);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void makeBall_overSize() {
		new Ball(11, BallStatus.NONE);
	}
}
