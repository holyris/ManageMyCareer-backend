package fr.univparis8.iut.csid.file;


import java.util.Objects;

public class File {
    private final String id;
    private final String name;
    private final String type;
    private final Long size;
    private final byte[] data;

    public File(String id, String name, String type, Long size, byte[] data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Long getSize() {
        return size;
    }

    public byte[] getData() {
        return data;
    }

    public File mergeWith(File other) {
        return FileBuilder.create()
                .withId(id)
                .withName(Objects.requireNonNullElse(other.name, name))
                .withType(Objects.requireNonNullElse(other.type, type))
                .withSize((Objects.requireNonNullElse(other.size, size)))
                .withData((Objects.requireNonNullElse(other.data, data)))
                .build();
    }


    public static final class FileBuilder{

        private String id;
        private String name;
        private String type;
        private Long size;
        private byte[] data;

        public FileBuilder() {
        }

        public static FileBuilder create() {
            return new FileBuilder();
        }

        public FileBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileBuilder withData(byte[] data) {
            this.data = data;
            return this;
        }

        public File build() {
            return new File(id, name, type, size, data);
        }
    }
}
