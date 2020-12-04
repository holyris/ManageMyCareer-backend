package fr.univparis8.iut.csid.folder;

import java.util.List;

public class FolderWithChildrenModel {
    private final String id;
    private final String name;
    private final List<FolderWithChildrenModel> childFolders;

    public FolderWithChildrenModel(String id, String name, List<FolderWithChildrenModel> childFolders) {
        this.id = id;
        this.name = name;
        this.childFolders = childFolders;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FolderWithChildrenModel> getChildFolders() {
        return childFolders;
    }

    public static final class FolderWithChildrenBuilder {
        private String id;
        private String name;
        private List<FolderWithChildrenModel> childFolders;

        private FolderWithChildrenBuilder() {
        }

        public static FolderWithChildrenBuilder create() {
            return new FolderWithChildrenBuilder();
        }

        public FolderWithChildrenBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FolderWithChildrenBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FolderWithChildrenBuilder withChildFolders(List<FolderWithChildrenModel> childFolders) {
            this.childFolders = childFolders;
            return this;
        }

        public FolderWithChildrenModel build() {
            return new FolderWithChildrenModel(id, name, childFolders);
        }
    }
}
