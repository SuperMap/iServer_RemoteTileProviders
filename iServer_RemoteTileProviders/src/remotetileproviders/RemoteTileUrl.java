package remotetileproviders;

import com.supermap.services.components.spi.TiledMapProviderBase.TileImagePrameter;

/**
 * <p>
 * �ṩ�������ߵ�ͼ��Ƭurl�ķ�����
 * </p>
 */
public interface RemoteTileUrl {
    String getUrl(TileImagePrameter tileParameter);
}
