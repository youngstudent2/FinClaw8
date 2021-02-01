const proxy = require('http-proxy-middleware')
module.exports = {
    devServer: {
        port: 8000,
        /*
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        proxyTable: {
            '/api': {
                target: 'http://http://39.105.36.203:8080',//此处可以换成自己需要的地址
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/api'
                },
            }
        }
        */
    }
};