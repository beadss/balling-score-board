package frame;

import frame.ball.Ball;
import frame.ball.BallList;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * Created by naver on 2018. 11. 26..
 */
@AllArgsConstructor
public class FrameImpl implements Frame{

	private final BallList ballList;
	private Optional<Ball> beforeBall;

	public FrameImpl() {
		ballList = new BallList();
		beforeBall = Optional.empty();
	}

	@Override
	public boolean addBall(Ball ball) {
		checkAndThrow(ball);

		if(needNext()) {
			getBallList().add(processStatus(ball));

			if(needNext()) {
				return true;
			}
		}

		return false;
	}

	private Ball processStatus(Ball ball) {
		this.beforeBall
			.ifPresent(beforeBall -> ball.setBallStatus(beforeBall));

		beforeBall = Optional.of(ball);

		return ball;
	}

	protected final BallList getBallList() {
		return ballList;
	}

	protected boolean needNext() {
		return ballList.getPinSum() < 10 && ballList.getBallCount() < 2;
	}

	protected void checkAndThrow(Ball ball) {
		if(ballList.getBallCount() == 2) {
			throw new IllegalArgumentException("over frame ball count");
		}
		if(ballList.getPinSum() + ball.getPinCount() > 10) {
			throw new IllegalArgumentException("over frame pin count");
		}
	}
}
