package frame;

import frame.ball.Ball;

/**
 * Created by naver on 2018. 11. 26..
 */
public interface Frame {
	/**
	 * Ball 입력
	 * @return need next ball
	 */
	boolean addBall(Ball ball);
}
