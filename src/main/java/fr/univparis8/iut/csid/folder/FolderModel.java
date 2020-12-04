package fr.univparis8.iut.csid.folder;

public class FolderModel {

    private final String id;
    private final String name;
    private final FolderModel parentFolderModel;

    public FolderModel(String id, String name, FolderModel parentFolderModel) {
        this.id = id;
        this.name = name;
        this.parentFolderModel = parentFolderModel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FolderModel getParentFolderModel() {
        return parentFolderModel;
    }

    public FolderModel mergeWith(FolderModel other) {
        return FolderBuilder.create()
                .withId(other.getId())
                .withName(other.name != null ? other.name : name)
                .withParentFolder(other.getParentFolderModel())
                .build();
    }


    public static final class FolderBuilder {
        private String id;
        private String name;
        private FolderModel parentFolderModel;

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

        public FolderBuilder withParentFolder(FolderModel parentFolderModel) {
            this.parentFolderModel = parentFolderModel;
            return this;
        }

        public FolderModel build() {
            return new FolderModel(id, name, parentFolderModel);
        }
    }
}
