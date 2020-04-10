import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleExample{

	public static void main(String[] args) throws Exception {

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail job = (JobDetail)JobBuilder.newJob(QuartzJob.class)
						.withIdentity("myJob", "group1")
						.build();
		Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("myTrigger", "group1")
						.startNow()									// 지금 시작
						.withSchedule(SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(5)		// 5초마다
									.repeatForever())				// 계속 반복
						.build();			// 트리거 생성
		scheduler.scheduleJob(job, trigger);		// 스케줄에 job을 trigger 조건에 따라 실행하도록 추가함
	}
}
