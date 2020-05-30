package fr.univparis8.iut.csid.folder;

import java.util.List;

public class FolderWithChildrenDto {
    private String id;
    private String name;
    private List<FolderWithChildrenDto> childFolders;

    public FolderWithChildrenDto() {
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

    public List<FolderWithChildrenDto> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(List<FolderWithChildrenDto> childFolders) {
        this.childFolders = childFolders;
    }

    public static final class FolderWithChildrenDtoBuilder {
        private String id;
        private String name;
        private List<FolderWithChildrenDto> childFolders;

        private FolderWithChildrenDtoBuilder() {
        }

        public static FolderWithChildrenDtoBuilder create() {
            return new FolderWithChildrenDtoBuilder();
        }

        public FolderWithChildrenDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FolderWithChildrenDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FolderWithChildrenDtoBuilder withChildFolders(List<FolderWithChildrenDto> childFolders) {
            this.childFolders = childFolders;
            return this;
        }

        public FolderWithChildrenDto build() {
            FolderWithChildrenDto folderWithChildrenDto = new FolderWithChildrenDto();
            folderWithChildrenDto.setId(id);
            folderWithChildrenDto.setName(name);
            folderWithChildrenDto.setChildFolders(childFolders);
            return folderWithChildrenDto;
        }
    }
}
