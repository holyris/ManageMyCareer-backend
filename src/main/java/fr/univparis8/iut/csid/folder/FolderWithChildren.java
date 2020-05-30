package fr.univparis8.iut.csid.folder;

import java.util.List;

public class FolderWithChildren {
    private final String id;
    private final String name;
    private final List<FolderWithChildren> childFolders;

    public FolderWithChildren(String id, String name, List<FolderWithChildren> childFolders) {
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

    public List<FolderWithChildren> getChildFolders() {
        return childFolders;
    }

    public static final class FolderWithChildrenBuilder {
        private String id;
        private String name;
        private List<FolderWithChildren> childFolders;

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

        public FolderWithChildrenBuilder withChildFolders(List<FolderWithChildren> childFolders) {
            this.childFolders = childFolders;
            return this;
        }

        public FolderWithChildren build() {
            return new FolderWithChildren(id, name, childFolders);
        }
    }
}
