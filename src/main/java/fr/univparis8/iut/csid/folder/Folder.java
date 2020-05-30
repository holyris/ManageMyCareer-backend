package fr.univparis8.iut.csid.folder;

import fr.univparis8.iut.csid.file.File;

public class Folder {

    private final String id;
    private final String name;
    private final Folder parentFolder;

    public Folder(String id, String name, Folder parentFolder) {
        this.id = id;
        this.name = name;
        this.parentFolder = parentFolder;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public Folder mergeWith(Folder other) {
        return FolderBuilder.create()
                .withId(other.getId())
                .withName(other.name != null ? other.name : name)
                .withParentFolder(other.getParentFolder())
                .build();
    }


    public static final class FolderBuilder {
        private String id;
        private String name;
        private Folder parentFolder;

        private FolderBuilder() {
        }

        public static FolderBuilder create() {
            return new FolderBuilder();
        }

        public FolderBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FolderBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FolderBuilder withParentFolder(Folder parentFolder) {
            this.parentFolder = parentFolder;
            return this;
        }

        public Folder build() {
            return new Folder(id, name, parentFolder);
        }
    }
}
