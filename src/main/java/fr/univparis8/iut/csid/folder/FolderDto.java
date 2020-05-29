package fr.univparis8.iut.csid.folder;

public class FolderDto {

    private String id;
    private String name;
    private String folderId;

    public FolderDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }


    public static final class FolderDtoBuilder {
        private String id;
        private String name;
        private String folderId;

        private FolderDtoBuilder() {
        }

        public static FolderDtoBuilder create() {
            return new FolderDtoBuilder();
        }

        public FolderDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FolderDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FolderDtoBuilder withFolderId(String folderId) {
            this.folderId = folderId;
            return this;
        }

        public FolderDto build() {
            FolderDto folderDto = new FolderDto();
            folderDto.setId(id);
            folderDto.setName(name);
            folderDto.setFolderId(folderId);
            return folderDto;
        }
    }
}
