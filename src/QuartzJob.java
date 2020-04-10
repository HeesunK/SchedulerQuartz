import java.util.Date;

import org.quartz.*;

public class QuartzJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) {
		System.out.println("Job이 실행되었습니다. " + new Date());
	}
}
