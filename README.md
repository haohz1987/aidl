1.Glide缓存

    /**
     * @param context
     * @param imageView 放入的图片
     * @param qrCodeUrl 请求网址
     * @param mACache 本地缓存工具
     * @param cacheName 缓存到本地的网址标签名
     */
    public static void readCache(Context context,ImageView imageView, String qrCodeUrl,ACache mACache, String cacheName) {
        cacheName = cacheName+"_cache";
        //有缓存的网址
        if (!ACache.isEmpty(mACache.getAsString(cacheName))) {
            String qrCodeUrlCache = mACache.getAsString(cacheName);
            if (!GlideUtils.haveCache(context, qrCodeUrlCache)) {
                GlideUtils.noneCache(context,imageView, qrCodeUrl,mACache,cacheName);
                return;
            }
            if(ACache.isEmpty(qrCodeUrl)){
                Glide.with(context).load(GlideUtils.getCache(context, qrCodeUrlCache)).into(imageView);
                return;
            }
            if (qrCodeUrl.equals(qrCodeUrlCache)) {
                Glide.with(context).load(GlideUtils.getCache(context, qrCodeUrl)).into(imageView);
            }
            //缓存地址错误或不是最新
            else {
                GlideUtils.noneCache(context,imageView, qrCodeUrl,mACache,cacheName);
            }
        } else {
            GlideUtils.noneCache(context,imageView, qrCodeUrl,mACache,cacheName);
        }
    }























































































