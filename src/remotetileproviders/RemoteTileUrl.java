package remotetileproviders;

import com.supermap.services.components.spi.TiledMapProviderBase.TileImagePrameter;

/**
 * <p>
 * 提供构造在线地图瓦片url的方法。
 * </p>
 */
public interface RemoteTileUrl {
    String getUrl(TileImagePrameter tileParameter);
}
