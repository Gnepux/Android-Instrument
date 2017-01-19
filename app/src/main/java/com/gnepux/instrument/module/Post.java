package com.gnepux.instrument.module;

import java.util.List;

/**
 * Created by xupeng on 17/1/18.
 */

public class Post {

    /**
     * status : ok
     * count : 3
     * count_total : 5
     * pages : 2
     * posts : [{"id":55,"type":"post","slug":"gogogo","url":"http://localhost/php2/fanyin/2016/11/06/gogogo/","status":"publish","title":"星云大师:佛教的时空观 第一篇·时间(剎那不算短 劫波不算长)","title_plain":"星云大师:佛教的时空观 第一篇·时间(剎那不算短 劫波不算长)","content":"<p>haha gogogo<\/p>\n","excerpt":"<p>haha gogogo<\/p>\n","date":"2016-11-06 14:56:31","modified":"2016-11-15 11:55:39","categories":[{"id":7,"slug":"aa","title":"AA","description":"","parent":0,"post_count":5}],"tags":[],"author":{"id":1,"slug":"root","name":"root","first_name":"","last_name":"","nickname":"root","url":"","description":""},"comments":null,"attachments":[],"comment_count":0,"comment_status":"open","thumbnail":null,"custom_fields":{"views":["12"]},"thumbnail_size":"post-thumbnail","thumbnail_images":{"full":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300},"thumbnail":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-150x150.jpg","width":150,"height":150},"medium":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-300x214.jpg","width":300,"height":214},"medium_large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300},"large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300}}},{"id":47,"type":"post","slug":"xupeng","url":"http://localhost/php2/fanyin/2016/08/04/xupeng/","status":"publish","title":"佛经偈语中令人惊艳的句子","title_plain":"佛经偈语中令人惊艳的句子","content":"<p>gnepux<\/p>\n","excerpt":"<p>xxpp<\/p>\n","date":"2016-08-04 11:26:53","modified":"2016-11-15 11:56:16","categories":[{"id":3,"slug":"1","title":"1","description":"","parent":0,"post_count":2},{"id":7,"slug":"aa","title":"AA","description":"","parent":0,"post_count":5}],"tags":[],"author":{"id":1,"slug":"root","name":"root","first_name":"","last_name":"","nickname":"root","url":"","description":""},"comments":null,"attachments":[],"comment_count":4,"comment_status":"open","thumbnail":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-220x138.jpg","custom_fields":{"views":["42"]},"thumbnail_size":"post-thumbnail","thumbnail_images":{"full":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1.jpg","width":1920,"height":1200},"thumbnail":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-150x150.jpg","width":150,"height":150},"medium":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-300x188.jpg","width":300,"height":188},"medium_large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-768x480.jpg","width":768,"height":480},"large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-1024x640.jpg","width":1024,"height":640},"post-thumbnail":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha1-220x138.jpg","width":220,"height":138}}},{"id":32,"type":"post","slug":"title1","url":"http://localhost/php2/fanyin/2016/07/20/title1/","status":"publish","title":"农历七月十三 恭迎大势至菩萨圣诞","title_plain":"农历七月十三 恭迎大势至菩萨圣诞","content":"<p>demo<\/p>\n","excerpt":"<p>demo<\/p>\n","date":"2016-07-20 16:51:07","modified":"2016-11-15 11:57:16","categories":[{"id":5,"slug":"3","title":"3","description":"","parent":0,"post_count":1},{"id":7,"slug":"aa","title":"AA","description":"","parent":0,"post_count":5},{"id":9,"slug":"cc","title":"CC","description":"","parent":0,"post_count":1}],"tags":[],"author":{"id":1,"slug":"root","name":"root","first_name":"","last_name":"","nickname":"root","url":"","description":""},"comments":null,"attachments":[],"comment_count":0,"comment_status":"open","thumbnail":null,"custom_fields":{"views":["15"]},"thumbnail_size":"post-thumbnail","thumbnail_images":{"full":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha2.jpg","width":900,"height":1125},"thumbnail":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha2-150x150.jpg","width":150,"height":150},"medium":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha2-240x300.jpg","width":240,"height":300},"medium_large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha2-768x960.jpg","width":768,"height":960},"large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha2-819x1024.jpg","width":819,"height":1024}}}]
     * query : {"ignore_sticky_posts":true,"page":"1","count":"3"}
     */

    private String status;
    private int count;
    private int count_total;
    private int pages;
    /**
     * ignore_sticky_posts : true
     * page : 1
     * count : 3
     */

    private QueryBean query;
    /**
     * id : 55
     * type : post
     * slug : gogogo
     * url : http://localhost/php2/fanyin/2016/11/06/gogogo/
     * status : publish
     * title : 星云大师:佛教的时空观 第一篇·时间(剎那不算短 劫波不算长)
     * title_plain : 星云大师:佛教的时空观 第一篇·时间(剎那不算短 劫波不算长)
     * content : <p>haha gogogo</p>

     * excerpt : <p>haha gogogo</p>

     * date : 2016-11-06 14:56:31
     * modified : 2016-11-15 11:55:39
     * categories : [{"id":7,"slug":"aa","title":"AA","description":"","parent":0,"post_count":5}]
     * tags : []
     * author : {"id":1,"slug":"root","name":"root","first_name":"","last_name":"","nickname":"root","url":"","description":""}
     * comments : null
     * attachments : []
     * comment_count : 0
     * comment_status : open
     * thumbnail : null
     * custom_fields : {"views":["12"]}
     * thumbnail_size : post-thumbnail
     * thumbnail_images : {"full":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300},"thumbnail":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-150x150.jpg","width":150,"height":150},"medium":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-300x214.jpg","width":300,"height":214},"medium_large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300},"large":{"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300}}
     */

    private List<PostsBean> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class QueryBean {
        private boolean ignore_sticky_posts;
        private String page;
        private String count;

        public boolean isIgnore_sticky_posts() {
            return ignore_sticky_posts;
        }

        public void setIgnore_sticky_posts(boolean ignore_sticky_posts) {
            this.ignore_sticky_posts = ignore_sticky_posts;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }

    public static class PostsBean {
        private int id;
        private String type;
        private String slug;
        private String url;
        private String status;
        private String title;
        private String title_plain;
        private String content;
        private String excerpt;
        private String date;
        private String modified;
        /**
         * id : 1
         * slug : root
         * name : root
         * first_name :
         * last_name :
         * nickname : root
         * url :
         * description :
         */

        private AuthorBean author;
        private Object comments;
        private int comment_count;
        private String comment_status;
        private Object thumbnail;
        private CustomFieldsBean custom_fields;
        private String thumbnail_size;
        /**
         * full : {"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300}
         * thumbnail : {"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-150x150.jpg","width":150,"height":150}
         * medium : {"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-300x214.jpg","width":300,"height":214}
         * medium_large : {"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300}
         * large : {"url":"http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg","width":420,"height":300}
         */

        private ThumbnailImagesBean thumbnail_images;
        /**
         * id : 7
         * slug : aa
         * title : AA
         * description :
         * parent : 0
         * post_count : 5
         */

        private List<CategoriesBean> categories;
        private List<?> tags;
        private List<?> attachments;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_plain() {
            return title_plain;
        }

        public void setTitle_plain(String title_plain) {
            this.title_plain = title_plain;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getComment_status() {
            return comment_status;
        }

        public void setComment_status(String comment_status) {
            this.comment_status = comment_status;
        }

        public Object getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Object thumbnail) {
            this.thumbnail = thumbnail;
        }

        public CustomFieldsBean getCustom_fields() {
            return custom_fields;
        }

        public void setCustom_fields(CustomFieldsBean custom_fields) {
            this.custom_fields = custom_fields;
        }

        public String getThumbnail_size() {
            return thumbnail_size;
        }

        public void setThumbnail_size(String thumbnail_size) {
            this.thumbnail_size = thumbnail_size;
        }

        public ThumbnailImagesBean getThumbnail_images() {
            return thumbnail_images;
        }

        public void setThumbnail_images(ThumbnailImagesBean thumbnail_images) {
            this.thumbnail_images = thumbnail_images;
        }

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<?> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<?> attachments) {
            this.attachments = attachments;
        }

        public static class AuthorBean {
            private int id;
            private String slug;
            private String name;
            private String first_name;
            private String last_name;
            private String nickname;
            private String url;
            private String description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class CustomFieldsBean {
            private List<String> views;

            public List<String> getViews() {
                return views;
            }

            public void setViews(List<String> views) {
                this.views = views;
            }
        }

        public static class ThumbnailImagesBean {
            /**
             * url : http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg
             * width : 420
             * height : 300
             */

            private FullBean full;
            /**
             * url : http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-150x150.jpg
             * width : 150
             * height : 150
             */

            private ThumbnailBean thumbnail;
            /**
             * url : http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4-300x214.jpg
             * width : 300
             * height : 214
             */

            private MediumBean medium;
            /**
             * url : http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg
             * width : 420
             * height : 300
             */

            private MediumLargeBean medium_large;
            /**
             * url : http://localhost/php2/fanyin/wp-content/uploads/2016/07/buddha4.jpg
             * width : 420
             * height : 300
             */

            private LargeBean large;

            public FullBean getFull() {
                return full;
            }

            public void setFull(FullBean full) {
                this.full = full;
            }

            public ThumbnailBean getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(ThumbnailBean thumbnail) {
                this.thumbnail = thumbnail;
            }

            public MediumBean getMedium() {
                return medium;
            }

            public void setMedium(MediumBean medium) {
                this.medium = medium;
            }

            public MediumLargeBean getMedium_large() {
                return medium_large;
            }

            public void setMedium_large(MediumLargeBean medium_large) {
                this.medium_large = medium_large;
            }

            public LargeBean getLarge() {
                return large;
            }

            public void setLarge(LargeBean large) {
                this.large = large;
            }

            public static class FullBean {
                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class ThumbnailBean {
                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class MediumBean {
                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class MediumLargeBean {
                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class LargeBean {
                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }

        public static class CategoriesBean {
            private int id;
            private String slug;
            private String title;
            private String description;
            private int parent;
            private int post_count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getParent() {
                return parent;
            }

            public void setParent(int parent) {
                this.parent = parent;
            }

            public int getPost_count() {
                return post_count;
            }

            public void setPost_count(int post_count) {
                this.post_count = post_count;
            }
        }
    }
}
