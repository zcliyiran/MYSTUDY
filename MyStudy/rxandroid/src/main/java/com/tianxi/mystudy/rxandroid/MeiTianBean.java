package com.tianxi.mystudy.rxandroid;

import java.util.List;

/**
 * Created by admin on 16/10/18.
 */

public class MeiTianBean {

    private int status;
    private int next;


    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

        private AuthorBean author;

        private FeaturedArticleBean featuredArticle;


        private CategoryBean category;
        private int priority;


        private ArticleBean article;


        private List<ImageBean> image;

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public FeaturedArticleBean getFeaturedArticle() {
            return featuredArticle;
        }

        public void setFeaturedArticle(FeaturedArticleBean featuredArticle) {
            this.featuredArticle = featuredArticle;
        }

        public CategoryBean getCategory() {
            return category;
        }

        public void setCategory(CategoryBean category) {
            this.category = category;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public ArticleBean getArticle() {
            return article;
        }

        public void setArticle(ArticleBean article) {
            this.article = article;
        }

        public List<ImageBean> getImage() {
            return image;
        }

        public void setImage(List<ImageBean> image) {
            this.image = image;
        }

        public static class AuthorBean {
            private String authorId;
            private String name;
            private String avatar;
            private String image;
            private Object logo;
            private String introduction;
            private int contactType;
            private String contactId;
            private int gender;
            private int contract;
            private int serviceType;
            private Object serviceParam;


            private EntityStatsBean entityStats;

            public String getAuthorId() {
                return authorId;
            }

            public void setAuthorId(String authorId) {
                this.authorId = authorId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Object getLogo() {
                return logo;
            }

            public void setLogo(Object logo) {
                this.logo = logo;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getContactType() {
                return contactType;
            }

            public void setContactType(int contactType) {
                this.contactType = contactType;
            }

            public String getContactId() {
                return contactId;
            }

            public void setContactId(String contactId) {
                this.contactId = contactId;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getContract() {
                return contract;
            }

            public void setContract(int contract) {
                this.contract = contract;
            }

            public int getServiceType() {
                return serviceType;
            }

            public void setServiceType(int serviceType) {
                this.serviceType = serviceType;
            }

            public Object getServiceParam() {
                return serviceParam;
            }

            public void setServiceParam(Object serviceParam) {
                this.serviceParam = serviceParam;
            }

            public EntityStatsBean getEntityStats() {
                return entityStats;
            }

            public void setEntityStats(EntityStatsBean entityStats) {
                this.entityStats = entityStats;
            }

            public static class EntityStatsBean {
                private int read;
                private int like;
                private int dislike;
                private int comment;
                private int favorite;
                private int share;

                public int getRead() {
                    return read;
                }

                public void setRead(int read) {
                    this.read = read;
                }

                public int getLike() {
                    return like;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public int getDislike() {
                    return dislike;
                }

                public void setDislike(int dislike) {
                    this.dislike = dislike;
                }

                public int getComment() {
                    return comment;
                }

                public void setComment(int comment) {
                    this.comment = comment;
                }

                public int getFavorite() {
                    return favorite;
                }

                public void setFavorite(int favorite) {
                    this.favorite = favorite;
                }

                public int getShare() {
                    return share;
                }

                public void setShare(int share) {
                    this.share = share;
                }
            }
        }

        public static class FeaturedArticleBean {
            private long publishTime;
            private int priority;

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }
        }

        public static class CategoryBean {
            private int categoryId;
            private String name;
            private String englishName;
            private String icon;
            private Object image;
            private int priority;

            private CategoryGroupBean categoryGroup;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEnglishName() {
                return englishName;
            }

            public void setEnglishName(String englishName) {
                this.englishName = englishName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public CategoryGroupBean getCategoryGroup() {
                return categoryGroup;
            }

            public void setCategoryGroup(CategoryGroupBean categoryGroup) {
                this.categoryGroup = categoryGroup;
            }

            public static class CategoryGroupBean {
                private int categoryGroupId;
                private String name;
                private String englishName;
                private String icon;
                private String largeIcon;
                private String color;
                private String image;

                public int getCategoryGroupId() {
                    return categoryGroupId;
                }

                public void setCategoryGroupId(int categoryGroupId) {
                    this.categoryGroupId = categoryGroupId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getEnglishName() {
                    return englishName;
                }

                public void setEnglishName(String englishName) {
                    this.englishName = englishName;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getLargeIcon() {
                    return largeIcon;
                }

                public void setLargeIcon(String largeIcon) {
                    this.largeIcon = largeIcon;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }

        public static class ArticleBean {
            private String articleId;
            private String title;
            private String summary;
            private String thumbnail;
            private int renderType;
            private String url;
            private String weblink;
            private long publishTime;
            private long createdTime;
            private long modifiedTime;
            /**
             * read : 64806
             * like : 38
             * dislike : 0
             * comment : 1
             * favorite : 25
             * share : 13
             */

            private ArticleStatsBean articleStats;
            private List<?> tags;

            public String getArticleId() {
                return articleId;
            }

            public void setArticleId(String articleId) {
                this.articleId = articleId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public int getRenderType() {
                return renderType;
            }

            public void setRenderType(int renderType) {
                this.renderType = renderType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWeblink() {
                return weblink;
            }

            public void setWeblink(String weblink) {
                this.weblink = weblink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public long getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(long createdTime) {
                this.createdTime = createdTime;
            }

            public long getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(long modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public ArticleStatsBean getArticleStats() {
                return articleStats;
            }

            public void setArticleStats(ArticleStatsBean articleStats) {
                this.articleStats = articleStats;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }

            public static class ArticleStatsBean {
                private int read;
                private int like;
                private int dislike;
                private int comment;
                private int favorite;
                private int share;

                public int getRead() {
                    return read;
                }

                public void setRead(int read) {
                    this.read = read;
                }

                public int getLike() {
                    return like;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public int getDislike() {
                    return dislike;
                }

                public void setDislike(int dislike) {
                    this.dislike = dislike;
                }

                public int getComment() {
                    return comment;
                }

                public void setComment(int comment) {
                    this.comment = comment;
                }

                public int getFavorite() {
                    return favorite;
                }

                public void setFavorite(int favorite) {
                    this.favorite = favorite;
                }

                public int getShare() {
                    return share;
                }

                public void setShare(int share) {
                    this.share = share;
                }
            }
        }

        public static class ImageBean {
            private String url;
            private int type;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
