package frame;

/**
 * Created by naver on 2018. 11. 26..
 */
public class FrameIssuer {
	private int i = 0;

	public Frame issue() {
		i++;

		if(i < 10) {
			return new FrameImpl();
		} else if(i == 10){
			return new TenthFrame();
		} else {
			throw new IllegalStateException("다음 프레임이 없습니다.");
		}

	}
}
