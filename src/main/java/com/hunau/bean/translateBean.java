package com.hunau.bean;

/**
 * @author Wking
 * @create 2020-12-08 14:51
 */
public class translateBean {


    /**
     * @author Wking
     * @create 2020-12-08 14:30
     */

        Long fileId;
        String status;
        String filename;
        String createTime;

        public translateBean() {
        }

        public translateBean(Long fileId, String status, String filename, String createTime) {
            this.fileId = fileId;
            this.status = status;
            this.filename = filename;
            this.createTime = createTime;
        }

        public Long getFileId() {
            return fileId;
        }

        public void setFileId(Long fileId) {
            this.fileId = fileId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "fileTranslateBean{" +
                    "fileId=" + fileId +
                    ", status='" + status + '\'' +
                    ", filename='" + filename + '\'' +
                    ", createTime='" + createTime + '\'' +
                    '}';
        }


}
