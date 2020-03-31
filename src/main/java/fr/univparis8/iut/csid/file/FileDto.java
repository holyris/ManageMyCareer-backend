package fr.univparis8.iut.csid.file;

public class FileDto {
    private String id;
    private String name;
    private String type;
    private Long size;
    private byte[] data;

    public FileDto() {
    }

    public FileDto(String id, String name, String type, Long size, byte[] data) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.data = data;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public static final class FileDtoBuilder{
        private String id;
        private String name;
        private String type;
        private Long size;
        private byte[] data;

        public FileDtoBuilder() {
        }

        public static FileDtoBuilder create(){return new FileDtoBuilder();}

        public FileDtoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public FileDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FileDtoBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public FileDtoBuilder withSize(Long size) {
            this.size = size;
            return this;
        }

        public FileDtoBuilder withData(byte[] data) {
            this.data = data;
            return this;
        }

        public FileDto build() {
            FileDto fileDto = new FileDto();
            fileDto.setId(id);
            fileDto.setName(name);
            fileDto.setType(type);
            fileDto.setSize(size);
            fileDto.setData(data);
            return fileDto;
        }
    }
}
