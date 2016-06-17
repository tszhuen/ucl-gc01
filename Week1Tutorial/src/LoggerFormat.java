import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggerFormat extends Formatter {

	@Override
	public String format(LogRecord record) {

		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("\n");
		
		stringBuffer.append(formatDate(record.getMillis()));

		stringBuffer.append(record.getSourceClassName());

		stringBuffer.append(record.getSourceMethodName());

		stringBuffer.append(record.getLevel());

		stringBuffer.append(record.getMessage());
		
		stringBuffer.append("\n");
		
		return stringBuffer.toString();
	}

	private String formatDate(long millis) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
		return dateFormat.format(new Date(millis));
	}
	
}