package bkav.com.app.notify.impl;


import bkav.com.app.notify.service.NotifyAlgorithm;

import java.util.Arrays;
import java.util.List;

/**
 * Created by truonglx on 09/10/2017.
 */
public class NotifyAlgorithmImpl implements NotifyAlgorithm {
		private static final long serialVersionUID = -6460372623358527940L;

		public NotifyAlgorithmImpl() {

		}

		public List<Long> getReceiver() {
				return Arrays.asList(1l, 2l);
		}
}
