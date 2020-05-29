package fr.univparis8.iut.csid.folder;

public class Folder {

    private final String id;
    private final String name;
    private final Folder folder;

    public Folder(String id, String name, Folder folder) {
        this.id = id;
        this.name = name;
        this.folder = folder;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Folder getFolder() {
        return folder;
    }


    public static final class FolderBuilder {
        private String id;
        private String name;
        private Folder folder;

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

        public FolderBuilder withFolder(Folder folder) {
            this.folder = folder;
            return this;
        }

        public Folder build() {
            return new Folder(id, name, folder);
        }
    }
}
