package requestBuilders;

import java.net.URI;

public class URIDefinition {
    protected final URI UPLOAD_FILE_URI = URI.create("https://content.dropboxapi.com/2/files/upload");
    protected final URI GET_METADATA_URI = URI.create("https://api.dropboxapi.com/2/sharing/get_file_metadata");
    protected final URI DELETE_FILE_URI = URI.create("https://api.dropboxapi.com/2/files/delete_v2");
}
