### һ�����

iServer_RemoteTileProviders�ǰ����û�����iServer��չ�����Խӵ��������ߵ�ͼ�����ṩ�ߵĽ��������

### ������չ����

�û����Լ̳�[ProviderBase](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/ProviderBase.java) �����࣬���ۺϵ����������ߵ�ͼ����
��Ҫʵ��List<RemoteTileMapParameter> remoteTileMapParameters()�������û���Ҫ�ṩ���������ߵ�ͼ�ĵ�ͼ�������������¼�����

<table cellspacing="0px" align="center">
	<col style="width: 20%;">
	<col style="width: 20%;">
	<col style="width: 60%;">
	<tr>
		<td><b>����</b></td>
		<td><b>����</b></td>
		<td><b>����</b></td>
	</tr>
	<tr>
		<td>mapName</td>
		<td>String</td>
		<td>��ͼ����</td>
	</tr>
	<tr>
		<td>origin</td>
		<td>Point2D</td>
		<td>��Ƭԭ�㡣</td>
	</tr>
	<tr>
		<td>bounds</td>
		<td>Rectangle2D</td>
		<td>ȫͼ��Χ��</td>
	</tr>
	<tr>
		<td>prjCoordSys</td>
		<td>PrjCoordSys</td>
		<td>��ͼͶӰ��</td>
	</tr>
	<tr>
		<td>scales</td>
		<td>double[]</td>
		<td>��ͼ�����߼��ϡ�</td>
	</tr>
	<tr>
		<td>resolutions</td>
		<td>double[]</td>
		<td>��ͼ�ֱ��ʼ��ϡ�</td>
	</tr>
	<tr>
		<td>remoteTileUrl</td>
		<td>RemoteTileUrl</td>
		<td>�ӿڱ��������ڹ���������Ƭ��URL��</td>
	</tr>
</table>

ע�⣺���зֱ��ʼ��Ϻͱ����߼��ϣ��û�����������һ�����������û������ã����ֻ��������һ����Ĭ��ͨ��TileTool�����ṩ��ת������resolutionToScale��scaleToResolutionת���õ���һ����������������Ĳ�����Ϊ��Ҫ�������û�����Ҫ���á�
SuperMapĬ�ϵ�����ϵΪX������������,Y�����������¡�������������ߵ�ͼ��Ĭ������ϵ��supermapĬ�ϵ�����ϵ��ͬ�Ļ�,��ô��Ƭ���кſ����漰��ת����������μ�[���ֵ�������ͼ�����������](https://github.com/cxk910204/test3/blob/master/%E9%83%A8%E5%88%86%E7%AC%AC%E4%B8%89%E6%96%B9%E5%9C%B0%E5%9B%BE%E6%9C%8D%E5%8A%A1%E5%8F%82%E6%95%B0%E4%BB%8B%E7%BB%8D.docx) ����չʾ����

### �������ò���

���[���úͲ���](https://github.com/cxk910204/test3/blob/master/%E9%85%8D%E7%BD%AE%E5%92%8C%E9%83%A8%E7%BD%B2.docx)

### �ġ���չʾ��

�����ṩ������ʾ����

1.[�ȸ��ͼ����ʾ��](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/GoogleMapsMapProvider.java)

2.[���ѵ�ͼ����ʾ��](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/SosoMapProvider.java)

3.[���ͼ��ͼ����ʾ��](https://github.com/cxk910204/test3/blob/master/iServer_RemoteTileProviders/src/remotetileproviders/TiandituMapProvider.java)

