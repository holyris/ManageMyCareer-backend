package fr.univparis8.iut.csid.folder;

public class FolderDto {

    private String id;
    private String name;
    private String parentFolderId;

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

    public String getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
        this.parentFolderId = parentFolderId;
    }


    public static final class FolderDtoBuilder {
        private String id;
        private String name;
        private String parentFolderId;

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

        public FolderDtoBuilder withParentFolderId(String parentFolderId) {
            this.parentFolderId = parentFolderId;
            return this;
        }

        public FolderDto build() {
            FolderDto folderDto = new FolderDto();
            folderDto.setId(id);
            folderDto.setName(name);
            folderDto.setParentFolderId(parentFolderId);
            return folderDto;
        }
    }
}
