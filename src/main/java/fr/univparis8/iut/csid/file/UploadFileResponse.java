package fr.univparis8.iut.csid.file;

public class UploadFileResponse {
    private String name;
    private String downloadUri;
    private String type;
    private long size;

    public UploadFileResponse(String name, String downloadUri, String type, long size) {
        this.name = name;
        this.downloadUri = downloadUri;
        this.type = type;
        this.size = size;
    }

    public String getFileName() {
        return name;
    }

    public void setFileName(String fileName) {
        this.name = name;
    }

    public String getFileDownloadUri() {
        return downloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.downloadUri = downloadUri;
    }

    public String getFileType() {
        return type;
    }

    public void setFileType(String fileType) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
