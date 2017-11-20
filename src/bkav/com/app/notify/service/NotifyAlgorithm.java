package bkav.com.app.notify.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by truonglx on 06/10/2017.
 */
public interface NotifyAlgorithm extends Serializable {
		List<Long> getReceiver();
}
