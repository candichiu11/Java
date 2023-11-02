package org.example;

public class Process {

    public String id;
    public String key;
    public String category;
    public String description;
    public String name;
    public int version;
    public String resource;
    public String deploymentId;
    public String diagram;
    public boolean suspended;
    public String tenantId;
    public String versionTag;
    public int historyTimeToLive;
    public boolean startableInTasklist;

    public Process(String id, String key, String category, String description, String name, int version, String resource, String deploymentId, String diagram, boolean suspended, String tenantId, String versionTag, int historyTimeToLive, boolean startableInTasklist) {
        this.id = id;
        this.key = key;
        this.category = category;
        this.description = description;
        this.name = name;
        this.version = version;
        this.resource = resource;
        this.deploymentId = deploymentId;
        this.diagram = diagram;
        this.suspended = suspended;
        this.tenantId = tenantId;
        this.versionTag = versionTag;
        this.historyTimeToLive = historyTimeToLive;
        this.startableInTasklist = startableInTasklist;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public String getResource() {
        return resource;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public String getDiagram() {
        return diagram;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getVersionTag() {
        return versionTag;
    }

    public int getHistoryTimeToLive() {
        return historyTimeToLive;
    }

    public boolean isStartableInTasklist() {
        return startableInTasklist;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", resource='" + resource + '\'' +
                ", deploymentId='" + deploymentId + '\'' +
                ", diagram='" + diagram + '\'' +
                ", suspended=" + suspended +
                ", tenantId='" + tenantId + '\'' +
                ", versionTag='" + versionTag + '\'' +
                ", historyTimeToLive=" + historyTimeToLive +
                ", startableInTasklist=" + startableInTasklist +
                '}';
    }
}
