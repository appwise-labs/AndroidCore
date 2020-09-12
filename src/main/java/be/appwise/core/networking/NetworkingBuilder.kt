package be.appwise.core.networking

import android.content.Context

class NetworkingBuilder {
    private lateinit var context: Context
    private var endPoint: String = ""
    private var packageName: String = ""
    private var clientSecretValue = ""
    private var clientIdValue = ""
    private var appName = ""
    private var versionName = ""
    private var versionCode = ""
    private var apiVersion = ""
    private var applicationId = ""
    private var networkingListeners = NetworkingListeners.DEFAULT

    fun setContext(context: Context): NetworkingBuilder {
        this.context = context
        return this
    }

    fun getContext(): Context {
        return context
    }

    fun setNetworkingListeners(customNetworkingListeners: NetworkingListeners): NetworkingBuilder {
        this.networkingListeners = customNetworkingListeners
        return this
    }

    fun getNetworkingListeners(): NetworkingListeners {
        return networkingListeners
    }

    fun setPackageName(packageName: String): NetworkingBuilder {
        this.packageName = packageName
        return this
    }

    internal fun getPackageName(): String {
        return packageName
    }

    fun setEndPoint(endPoint: String): NetworkingBuilder {
        this.endPoint = endPoint
        return this
    }

    internal fun getEndPoint(): String {
        return endPoint
    }

    fun setClientSecretValue(clientSecretValue: String): NetworkingBuilder {
        this.clientSecretValue = clientSecretValue
        return this
    }

    internal fun getClientSecretValue(): String {
        return clientSecretValue
    }

    fun setClientIdValue(clientIdValue: String): NetworkingBuilder {
        this.clientIdValue = clientIdValue
        return this
    }

    internal fun getClientIdValue(): String {
        return clientIdValue
    }

    fun setAppName(appName: String): NetworkingBuilder {
        this.appName = appName
        return this
    }

    internal fun getAppName(): String {
        return appName
    }

    fun setVersionName(versionName: String): NetworkingBuilder {
        this.versionName = versionName
        return this
    }

    internal fun getVersionName(): String {
        return versionName
    }

    fun setVersionCode(versionCode: String): NetworkingBuilder {
        this.versionCode = versionCode
        return this
    }

    internal fun getVersionCode(): String {
        return versionCode
    }

    fun setApiVersion(apiVersion: String): NetworkingBuilder {
        this.apiVersion = apiVersion
        return this
    }

    internal fun getApiVersion(): String {
        return apiVersion
    }

    fun setApplicationId(applicationId: String): NetworkingBuilder {
        this.applicationId = applicationId
        return this
    }

    internal fun getApplicationId(): String {
        return applicationId
    }

    fun <T> build(apiManagerService: Class<T>? = null) {
        Networking.build(this, apiManagerService)
    }
}
