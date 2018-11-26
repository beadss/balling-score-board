package frame;

import frame.ball.Ball;
import frame.ball.BallStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naver on 2018. 11. 26..
 */
public class TenthFrame extends FrameImpl {

	@Override
	protected boolean needNext() {
		if(getBallList().getBallCount() < 2) {
			return true;
		} else {
			return needBonusBall(getBallList().getBallList());
		}
	}

	private boolean needBonusBall(List<Ball> ballList) {
		return ballList.size() == 2 && ballList.stream()
			.map(Ball::getBallStatus)
			.anyMatch(this::bonusBall);
	}

	private boolean bonusBall(BallStatus ballStatus) {
		return ballStatus == BallStatus.STRIKE || ballStatus == BallStatus.SPARE;
	}

	@Override
	protected void checkAndThrow(Ball ball) {
		List<Ball> tempList = new ArrayList<>(getBallList().getBallList());
		tempList.add(ball);

		if(needBonusBall(tempList)) {
			if((getBallList().getBallCount() == 3) || (getBallList().getPinSum() + ball.getPinCount() > 30)) {
				throw new IllegalArgumentException("over frame pin count");
			}

		} else if((getBallList().getBallCount() == 2) || (getBallList().getPinSum() + ball.getPinCount() > 20)) {
			throw new IllegalArgumentException("over frame pin count");
		}

	}

}
