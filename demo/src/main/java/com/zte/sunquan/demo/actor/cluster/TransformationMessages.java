package com.zte.sunquan.demo.actor.cluster;

import java.io.Serializable;

/**
 * Created by 10184538 on 2017/10/10.
 */
public interface TransformationMessages {
    String BACKEND_REGISTRATION = "BackendRegistration";

    class TransformationJob implements Serializable {
        private final String text;

        public TransformationJob(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TransformationJob{");
            sb.append("text='").append(text).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    class TransformationResult implements Serializable {
        private final String text;

        public TransformationResult(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class JobFailed implements Serializable {
        private final String reason;
        private final TransformationJob job;

        public JobFailed(String reason, TransformationJob job) {
            this.reason = reason;
            this.job = job;
        }

        public String getReason() {
            return reason;
        }

        public TransformationJob getJob() {
            return job;
        }
    }


}
