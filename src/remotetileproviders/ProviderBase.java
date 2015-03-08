package remotetileproviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.supermap.services.components.commontypes.Layer;
import com.supermap.services.components.commontypes.LayerType;
import com.supermap.services.components.commontypes.MapParameter;
import com.supermap.services.components.commontypes.OutputFormat;
import com.supermap.services.components.commontypes.Point2D;
import com.supermap.services.components.commontypes.PrjCoordSys;
import com.supermap.services.components.commontypes.Rectangle;
import com.supermap.services.components.commontypes.Rectangle2D;
import com.supermap.services.components.commontypes.RectifyType;
import com.supermap.services.providers.RemoteTileProviderBase;
import com.supermap.services.util.TileTool;

/**
 * <p>
 * 第三方在线地图服务提供者基类。
 * </p>
 */
public abstract class ProviderBase extends RemoteTileProviderBase {
    private List<RemoteTileMapParameter> remoteTileMapParameters;

    /**
     * <p>
     * 在线地图参数集合。
     * </p>
     * @return 在线地图参数集合。
     */
    abstract List<RemoteTileMapParameter> remoteTileMapParameters();

    /**
     * <p>
     * 获取瓦片url地址。
     * </p>
     * @param tileImagePrameter 瓦片参数。
     * @return 瓦片url地址。
     */
    @Override
    protected String getTileImageUrl(TileImagePrameter tileImagePrameter) {
        return get(tileImagePrameter.mapName).remoteTileUrl.getUrl(tileImagePrameter);
    }

    /**
     * <p>
     * 获取在线地图支持的分辨率数组。
     * </p>
     * @param mapName地图名。
     * @return 分辨率数组。
     */
    @Override
    public double[] getSupportResolutions(String mapName) {
        RemoteTileMapParameter mapParameter = get(mapName);
        double[] resolutions = get(mapName).resolutions;
        if (ArrayUtils.isNotEmpty(resolutions)) {
            return resolutions;
        }
        double[] scales = get(mapName).scales;
        if (ArrayUtils.isEmpty(scales)) {
            throw new RuntimeException("分比率集合和比例尺集合均为空,请设置 ");
        }
        resolutions = new double[scales.length];
        for (int i = 0; i < scales.length; i++) {
            resolutions[i] = TileTool.scaleToResolution(scales[i], 96, mapParameter.prjCoordSys.coordUnit);
        }
        return resolutions;
    }

    @Override
    protected List<String> initSupportedMapNames() {
        return allMapParameterNames();
    }

    @Override
    protected Map<String, MapParameter> initDefaultMapParameter() {
        Map<String, MapParameter> result = new HashMap<String, MapParameter>();
        for (int i = 0; i < getParameters().size(); i++) {
            RemoteTileMapParameter mapParameter = get(allMapParameterNames().get(i));
            result.put(mapParameter.mapName,
                    getMapParameter(mapParameter.mapName, mapParameter.prjCoordSys, getSupportScales(mapParameter.mapName), mapParameter.bounds));
        }
        return result;
    }

    @Override
    protected Point2D getOrigin(String mapName) {
        return get(mapName).origin;
    }

    @Override
    public OutputFormat[] getSupportImageFormat(String mapName) {
        return new OutputFormat[0];
    }

    @Override
    protected boolean cacheEnabled() {
        return false;
    }

    private double[] getSupportScales(String mapName) {
        RemoteTileMapParameter mapParameter = get(mapName);
        double[] scales = get(mapName).scales;
        if (ArrayUtils.isNotEmpty(scales)) {
            return scales;
        }
        double[] resolutions = get(mapName).resolutions;
        if (ArrayUtils.isEmpty(resolutions)) {
            throw new RuntimeException("分比率集合和比例尺集合均为空,请设置 ");
        }
        scales = new double[resolutions.length];
        for (int i = 0; i < resolutions.length; i++) {
            scales[i] = TileTool.resolutionToScale(resolutions[i], 96, mapParameter.prjCoordSys.coordUnit);
        }
        return resolutions;
    }

    private List<RemoteTileMapParameter> getParameters() {
        if (this.remoteTileMapParameters == null) {
            this.remoteTileMapParameters = remoteTileMapParameters();
        }
        return this.remoteTileMapParameters;
    }

    private RemoteTileMapParameter get(String mapName) {
        for (RemoteTileMapParameter mapParameter : getParameters()) {
            if (mapParameter.mapName.equals(mapName)) {
                return mapParameter;
            }
        }
        throw new RuntimeException("没有相应的RemoteTileMapParameter");
    }

    private List<String> allMapParameterNames() {
        List<String> mapNames = new ArrayList<String>();
        if (getParameters().size() != 0) {
            for (int i = 0; i < getParameters().size(); i++) {
                mapNames.add(getParameters().get(i).mapName);
            }
        }
        return mapNames;
    }

    private MapParameter getMapParameter(String mapName, PrjCoordSys prjCoordSys, double[] scales, Rectangle2D bounds) {
        MapParameter mapParameter = new MapParameter();
        mapParameter.name = mapName;
        mapParameter.viewer = new Rectangle(0, 0, 256, 256);
        mapParameter.bounds = bounds;
        mapParameter.center = mapParameter.bounds.center();
        double[] resolutions = getSupportResolutions(mapName);
        int viewerHeight = mapParameter.viewer.getHeight();
        int viewerWidth = mapParameter.viewer.getWidth();
        mapParameter.viewBounds = new Rectangle2D(mapParameter.center.x - resolutions[0] * viewerWidth * 0.5, mapParameter.center.y - resolutions[0]
                * viewerHeight * 0.5, mapParameter.center.x + resolutions[0] * viewerWidth * 0.5, mapParameter.center.y + resolutions[0] * viewerHeight * 0.5);
        mapParameter.customEntireBoundsEnabled = false;
        mapParameter.prjCoordSys = prjCoordSys;
        mapParameter.coordUnit = mapParameter.prjCoordSys.coordUnit;
        mapParameter.distanceUnit = mapParameter.prjCoordSys.coordUnit;
        mapParameter.rectifyType = RectifyType.BYCENTERANDMAPSCALE;
        mapParameter.visibleScalesEnabled = true;
        mapParameter.visibleScales = scales;
        mapParameter.scale = mapParameter.visibleScales[0];
        RemoteTileMapLayer layer = new RemoteTileMapLayer();
        layer.name = mapParameter.name;
        layer.bounds = new Rectangle2D(mapParameter.bounds);
        layer.visible = true;
        mapParameter.layers = Arrays.asList(new Layer[] { layer });
        return mapParameter;
    }

    private static class RemoteTileMapLayer extends Layer {
        private static final long serialVersionUID = 1L;

        public RemoteTileMapLayer() {
            this.type = LayerType.CUSTOM;
        }

        /**
         * <p>
         * 复制图层。
         * </p>
         * @return Layer对象
         */
        public Layer copy() {
            RemoteTileMapLayer layer = new RemoteTileMapLayer();
            layer.name = this.name;
            layer.type = this.type;
            layer.bounds = new Rectangle2D(this.bounds);
            layer.caption = this.caption;
            layer.visible = this.visible;
            return layer;
        }
    }

}
